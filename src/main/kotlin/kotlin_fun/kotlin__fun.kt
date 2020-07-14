package kotlin_fun

//普通函数
//没有返回值 Unit=void
fun test():Unit{

}

//有返回值
fun by():Int{
    return 200
}

fun add(a:Int ,b:Int):Int{
    return a+b
}

fun add1(a:Int ,b:Int):Int=a+b

//可变参数
fun add2(vararg names:Int){
    var result=0
    for (value in names){
        result+=value
    }
    println(result)
}

//函数内部可以再定义数据  局部函数
fun showView(){
    fun loaddata()="图片"
    fun showList(){
        //下载数据
        loaddata().also {
            println("展示下载的数据：$it")
        }
    }
    showList()
}
/*
fun showView(){
    fun loaddata()="图片"
    fun showList(){
        //下载数据
        val img=loaddata()
        //展示数据
        println("展示下载的数据：$img")
    }
    showList()
}
*/

//数据类
/*使用要求：
  1.数据类的主构造函数必须有至少一个参数
  2.参数必须使用var 或者 val修饰
  3.不能使用  open inner abstract
   */
data class User(
    var name:String,
    var password:String,
    var id:Int){
}



//嵌套和内部类
class Back{
    var money:Money= Money(0)
    //钱
    class Money(var num:Int){}
    //银行卡 嵌套类是独立于宿主类的 不能访问宿主类的属性和方法
    //内部类就可以 inner
    inner class Card(){
        fun save(count:Int){
           money.num+=count
        }
        fun withdraw(count:Int) {
            if (money.num>=count){
                money.num-=count
                println("取款成功 余额为${money.num}")
            }else{
                println("余额不足")
            }
        }
    }
}


//匿名内部类
//接口 ->统一接口
//接口不能被实例化 只能实例化接口的实现类
interface OnTouchListener{
    fun OnTouchEvent(type:String)
}

fun didTouch(listener: OnTouchListener){
    listener.OnTouchEvent("手指按下")
}

//方法一  定义类实现的接口 ->实例化这个实现类
class ButtonListner:OnTouchListener{
    override fun OnTouchEvent(type: String) {
       println("接收到的事件是：$type")
    }

}


fun main() {

    /*
    //方法二 匿名类 object
    didTouch(object :OnTouchListener{
        override fun OnTouchEvent(type: String) {
            println("接收到的事件是：$type")
        }
    })
*/

  /* var btn=ButtonListner()
    didTouch(btn)*/
   /* ButtonListner().also {
        didTouch(it)
    }
    ButtonListner().apply {
        didTouch(this)
    }*/

   /* var back=Back().Card()
    back.save(200)
    back.withdraw(20)
    */

    //Back.Card()
   /* User("Avicii","20180428",1).also {
        println(it)
    }*/
    //showView()
}


//匿名内部类
class QQ{
    fun show(){
        //本来是要实例化的 但是可以用匿名类来实现
        dipathTouch(object :OntouchListener{
            override fun OntouchEvent(type: String) {
                println("接收到的事件是：$type")
            }
        })
    }

    fun dipathTouch(listener: OntouchListener){
        listener.OntouchEvent("手指在滑动")
    }

    interface OntouchListener{
        fun OntouchEvent(type:String)
    }
}