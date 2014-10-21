# encoding: UTF-8
# language: no

Egenskap: Liste ut alle ressurser på toppnivå
  Som en bruker av api
  For å få vite kva for ressurser som er tilgjengelige
  Ønsker jeg å kunne få en liste over desse

  Scenario: GET av http://clubadmin/ med mediatype json-ld
    Når jeg gjør en GET av http://clubadmin/
    Så får jeg en liste over ressurser og linker
