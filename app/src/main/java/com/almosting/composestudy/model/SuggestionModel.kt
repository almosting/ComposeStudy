package com.almosting.composestudy.model

data class SuggestionModel(val tag: String) {
    val id = tag.hashCode()
}

