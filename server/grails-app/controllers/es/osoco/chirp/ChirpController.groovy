package es.osoco.chirp

import grails.converters.JSON

class ChirpController {
    def timeline = {
        render((params.chirper ? Chirp.findAllByChirper(params.chirper) : []) as JSON)
    }
}