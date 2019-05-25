import os
import riak
program = riak.RiakClient(pb_port=8087)

print("Witaj w programie rejestrujacym auta w komisie.")
print("")
markaIn = raw_input("Podaj marke auta: ")
print("")
modelIn = raw_input("Podaj model auta: ")
print("")
rokProdukcjiIn = raw_input("Podaj rok produkcji auta: ")
print("")
rodzajNadwoziaIn = raw_input("Podaj wersje nadwozia: ")
auto = {'marka': markaIn, 'model': modelIn, 'rokProdukcji': rokProdukcjiIn, 'rodzajNadwozia': rodzajNadwoziaIn}
autoBucket = program.bucket("S13054")
newAuto = autoBucket.new(auto['marka'], data = auto)
print("Dodanie rekordu do bazy.")
newAuto.store()
getAuto = autoBucket.get(auto['marka'])
print(getAuto.encoded_data)
print("")
auto2 = ""
print("Jesli chcesz edytowac marke wpisz 1")
print("Jesli chcesz edytowac model wpisz 2")
print("Jesli chcesz edytowac rok produkcji wpisz 3")
print("Jesli chcesz edytowac rodzaj nadwozia wpisz 4")
number = raw_input("Co chcesz zedytowac: ")

if number == "1":
	print("")
	markaIn2 = raw_input("Wprowadz marke: ")
	markaIn = markaIn2
	auto2 = {'marka': markaIn2, 'model': modelIn, 'rokProdukcji': rokProdukcjiIn, 'rodzajNadwozia': rodzajNadwoziaIn}

if number == "2":
	print("")
	modelIn2 = raw_input("Wprowadz model: ")
	modelIn = modelIn2
	auto2 = {'marka': markaIn, 'model': modelIn2, 'rokProdukcji': rokProdukcjiIn, 'rodzajNadwozia': rodzajNadwoziaIn}

if number == "3":
	print("")
	rokProdukcjiIn2 = raw_input("Wprowadz rok produkcji: ")
	rokProdukcjiIn = rokProdukcjiIn2
	auto2 = {'marka': markaIn, 'model': modelIn, 'rokProdukcji': rokProdukcjiIn2, 'rodzajNadwozia': rodzajNadwoziaIn}

if number == "4":
	print("")
	rodzajNadwoziaIn2 = raw_input("Wprowadz rodzaj nadwozia: ")
	rodzajNadwoziaIn = rodzajNadwoziaIn2
	auto2 = {'marka': markaIn, 'model': modelIn, 'rokProdukcji': rokProdukcjiIn, 'rodzajNadwozia': rodzajNadwoziaIn}

autoBucket  = program.bucket("S13054")
newAuto = autoBucket.new(auto['marka'], data=auto2)
print("Modyfikacja rekordu w bazie.")
newAuto.store()
getAuto = autoBucket.get(auto['marka'])
print(getAuto.encoded_data)
print("Usuwam rekord z bazy.")
getAuto.delete()
print(getAuto.encoded_data)