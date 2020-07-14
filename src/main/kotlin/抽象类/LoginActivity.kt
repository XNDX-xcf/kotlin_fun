package 抽象类

class LoginActivity(override var tittle: String) :BaseActivity(){
    override fun onCreate() {
        println("开始搭建界面")
    }

    override fun onPause(){
        super.onPause()
        println("界面暂停了")
    }

    override fun onDestory() {
        super.onDestory()
        println("界面消失了")
    }
}