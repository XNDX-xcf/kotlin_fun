package 抽象类

class MainActivity(override var tittle: String) :BaseActivity() {
    override fun onCreate() {
        println("主页界面被创建了")
    }
}