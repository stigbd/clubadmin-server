* Start med påloggings-scenario

* Liste over arrangementer
For å hente html-liste over arrangementer, inkl id:
curl -u <username:password> "http://lyn.registra.no/admin/"

* Implementer import av html-liste over påmeldte til arrangement=arrid, feks trening=259
For å hente html-liste over påmeldte til gitt arr=<arrid>, forsøk
curl -u <username:password> "http://lyn.registra.no/admin/?action=pmldte&arrid=259"

* Must implment security. Consult
- https://jersey.java.net/documentation/latest/security.html
- https://simplapi.wordpress.com/2015/09/19/jersey-jax-rs-securitycontext-in-action/
- Seems like a user (extends ExternalUser) must be implemented
- and definitely http://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
- and for the client, e.g. http://www.sitepoint.com/using-json-web-tokens-node-js/
