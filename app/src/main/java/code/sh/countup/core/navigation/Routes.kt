package code.sh.countup.core.navigation

object Routes {
    const val COUNTER_LIST = "COUNTER_LIST"
    const val CREATE_COUNTER = "CREATE_COUNTER"
    const val COUNTER = "counter/{id}"
    fun counter(id: Int) = "counter/$id"
}