package com.ogungor.tabprojecttest.feed.daily

 class ExampleList {

  private var list1= ArrayList<ArrayList<String>>()


  fun setList(position: Int,comment :String,teams:String,bet:String ){
   var list=ArrayList<String>()
   list.add(comment)
   list.add(teams)
   list.add(bet)
   this.list1.add(position,list)
  }

  fun getList(position:Int):ArrayList<String>
  {
   return list1[position]
  }


 }




