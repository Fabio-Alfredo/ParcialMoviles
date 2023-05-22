package com.example.music.data

val name = "algo"
val genero = "rock"
val instruments = "guitarra, teclado, otr"

val name2 = "alguna"
val genero2 = "jazz"
val instruments2 = "sax algo, sax tenor, violines etc"

var musics = mutableListOf(
    Music(name, genero, instruments),
    Music(name2, genero2, instruments2)
)