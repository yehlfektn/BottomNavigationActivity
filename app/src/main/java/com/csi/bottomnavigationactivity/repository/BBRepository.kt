package com.csi.bottomnavigationactivity.repository

import com.csi.bottomnavigationactivity.network.BBService

class BBRepository(
    private val service: BBService
) {
    fun getChars() = service.fetchCharacters()
}