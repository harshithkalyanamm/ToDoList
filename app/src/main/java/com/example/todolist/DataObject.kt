package com.example.todolist

object DataObject {
    var listdata= mutableListOf<Cardinfo>()

    fun setData(title: String,description:String){
        listdata.add(Cardinfo(title,description))

    }
    fun getAllData():List<Cardinfo> {
        return  listdata
    }

    fun getData(pos:Int):Cardinfo{
        return listdata[pos]
    }

    fun deleteData(pos:Int){
        listdata.removeAt(pos)

    }
    fun updateData(pos: Int,title: String,description: String){
        listdata[pos].title=title
        listdata[pos].description=description
    }
}