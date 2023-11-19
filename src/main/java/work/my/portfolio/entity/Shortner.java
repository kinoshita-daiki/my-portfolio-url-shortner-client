package work.my.portfolio.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * 短縮機
 * 
 * @author kinoshita daiki
 * @since 2023/11/06
 */
@RegisterForReflection
public record Shortner(String shortUrl, String longUrl) {
}