package work.my.portfolio;

import java.net.URI;
import java.util.Optional;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.netty.util.internal.StringUtil;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
import work.my.portfolio.entity.Shortner;
import work.my.portfolio.service.ShortnerClientService;

/**
 * URL変換Resources
 * 
 * @author kinoshita daiki
 * @since 2023/11/07
 */
@Path("/")
public class UrlConverterResources {

	@Inject
	@RestClient
	private ShortnerClientService service;

	/**
	 * 短いURLが入力された際の処理
	 * 
	 * @param shortUrlPath 短いURL
	 * @return 長いURLにリダイレクトするレスポンス
	 */
	@Path("{shortUrlPath}")
	@GET
	public Response onShortUrlInputted(@PathParam("shortUrlPath") String shortUrlPath) {
		return Optional.ofNullable(service.getShortnerByShortUrlPath(shortUrlPath))//
				.filter(s -> !StringUtil.isNullOrEmpty(s.longUrl()))//
				.map(Shortner::longUrl)//
				.map(URI::create)//
				.map(Response::seeOther)//
				.map(ResponseBuilder::build)//
				.orElseGet(() -> Response.status(Status.NOT_FOUND).build());
	}
}
