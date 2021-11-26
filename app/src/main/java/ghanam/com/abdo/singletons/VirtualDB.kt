package ghanam.com.abdo.singletons

import ghanam.com.abdo.dataclasses.Item

object VirtualDB {
    var items:MutableList<Item>
    var deliveryFee:Float
    var currentFilter:String
    var priceFilter:String
    init
    {
        deliveryFee=5.00f
        items= mutableListOf()
        currentFilter="all"
        priceFilter="mintomax"
    }

    fun addItem(ite:Item):Boolean
    {
        if (checkExestence(ite.name)){
            return false
        }
        items.add(ite)
        return true

    }
    private fun checkExestence(name:String?):Boolean
    {
        var found=false
        for (ite in items){
            if (ite.name==name){
                found=true
            }
        }
        return found
    }
    fun getItemsCount():Int
    {
        return items.size
    }
    fun clearCart()
    {
        items= mutableListOf()
    }
    fun increaseItemCount(name: String?):Int
    {
        var quantity=0
        for (ite in items){
            if (ite.name==name){
                ite.quantity++
                quantity=ite.quantity
                ite.totalPrice = quantity * ite.price
                return quantity
            }
        }
        return quantity
    }
    fun decreaseItemCount(name: String?):Int
    {
        var quantity=0
        for (ite in items){
            if (ite.name==name){
                if (ite.quantity>1) {
                    ite.quantity--
                    quantity = ite.quantity
                    ite.totalPrice = quantity * ite.price
                    return quantity
                }
                if(ite.quantity<=1) {
                    items.remove(ite)
                    return quantity
                }
            }
        }
        return quantity
    }
    fun calculateTotal():Float
    {
        var total=0.0f
        for (ite in items){
            total += ite.totalPrice
        }
        return total
    }
}