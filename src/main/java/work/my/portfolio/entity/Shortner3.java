package work.my.portfolio.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

/**
 * 短縮機
 * 
 * @author kinoshita daiki
 * @since 2023/11/06
 */
@Data
@RegisterForReflection
public class Shortner3 {

	public Shortner3() {
	}

	public Shortner3(String shortUrl, String longUrl) {
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
	}

	private String shortUrl;
	private String longUrl;
}