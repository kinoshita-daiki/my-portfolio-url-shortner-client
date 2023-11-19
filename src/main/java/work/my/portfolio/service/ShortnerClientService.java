package work.my.portfolio.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import work.my.portfolio.entity.Shortner;

@Path("/")
@RegisterRestClient
public interface ShortnerClientService {

	@Path("urlShortnerGetter")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Shortner getShortnerByLongUrl(String longUrl);

	/**
	 * 指定した短いURLに紐づいた長いURLでリダイレクトする
	 * 
	 * @param shortUrl 短いURL
	 * @return リダイレクトレスポンス
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{shortUrlPath}")
	@GET
	public Shortner getShortnerByShortUrlPath(@PathParam("shortUrlPath") String shortUrlPath);
}
