package io.konik.zugferd.entity;
/**
 * The Enum URISchemes.<br/>
 * 
 * @see <a href="http://en.wikipedia.org/wiki/URI_scheme#Official_IANA-registered_schemes">Official
 *      IANA-registered schemes</a>
 * 
 */
public enum UriSchemeNames {

	/** The telephone number scheme. */
	TEL("tel"),
	/** The email scheme */
	EMAIL("mailto");
	// FAX is Deprecated in RFC 3966 in favour of tel:. Listed as "Historical"
	public final String scheme;

	private UriSchemeNames(String scheme) {
		this.scheme = scheme;
	}
}
