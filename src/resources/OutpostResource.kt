package resources

data class OutpostResource(val id: Int, val name: String, var amount: Int) {
    override fun toString(): String {
        return "Ресурс: $id | Имя: $name | Количество: $amount"
    }
}