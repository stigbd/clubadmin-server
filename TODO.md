* Start med påloggings-scenario

* Liste over arrangementer
For å hente html-liste over arrangementer, inkl id:
curl -u <username:password> "http://lyn.registra.no/admin/"

* Implementer import av html-liste over påmeldte til arrangement=arrid, feks trening=259
For å hente html-liste over påmeldte til gitt arr=<arrid>, forsøk
curl -u <username:password> "http://lyn.registra.no/admin/?action=pmldte&arrid=259"


