package work.my.portfolio.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import work.my.portfolio.entity.Shortner;

/**
 * 短縮機Service(クライアント側)
 * 
 * @author kinoshita daiki
 * @since 2024/03/02
 */
@ApplicationScoped
@Path("/")
@RegisterRestClient
public interface ShortnerClientService {

	/**
	 * 指定した長いURLに紐づいた短縮機を取得する
	 * 
	 * @param longUrl 長いURL
	 * @return 短縮機
	 */
	@Path("urlShortnerGetter")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Shortner getShortnerByLongUrl(String longUrl);

	/**
	 * 指定した短いURLに紐づいた短縮機を取得する
	 * 
	 * @param shortUrl 短いURL
	 * @return 短縮機
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{shortUrlPath}")
	@GET
	public Shortner getShortnerByShortUrlPath(@PathParam("shortUrlPath") String shortUrlPath);
}
