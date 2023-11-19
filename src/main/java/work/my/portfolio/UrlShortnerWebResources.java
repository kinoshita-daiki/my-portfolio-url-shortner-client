package work.my.portfolio;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import work.my.portfolio.entity.Shortner;
import work.my.portfolio.service.ShortnerClientService;

/**
 * URL短縮機Resources
 * 
 * @author kinoshita daiki
 * @since 2023/11/07
 */
@Path("/urlShortner")
public class UrlShortnerWebResources {

	@Inject
	@RestClient
	private ShortnerClientService service;

	@CheckedTemplate
	private static class UrlShortenerTempletes {

		public static native TemplateInstance urlShortenerInput();

		public static native TemplateInstance urlShortenerOutput(Shortner urlShortner, String uri);
	}

	/**
	 * 入力フォームを返す
	 * 
	 * @return 入力フォーム
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance getInputPage() {
		return UrlShortenerTempletes.urlShortenerInput();
	}

	/**
	 * 変換ボタン押下時の処理
	 * 
	 * @param longUrl 入力された長いURL
	 * @return 出力フォーム
	 */
	@Produces(MediaType.TEXT_HTML)
	@POST
	public TemplateInstance onConvertButtonClicked(
			@FormParam("longUrl") String longUrl,
			@Context UriInfo uriInfo) {
		Shortner shortner = service.getShortnerByLongUrl(longUrl);
		return UrlShortenerTempletes.urlShortenerOutput(shortner, uriInfo.getBaseUri().toString());
	}
}
