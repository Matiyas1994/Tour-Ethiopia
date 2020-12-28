# [Tour Ethiopia](https://www.lonelyplanet.com/ethiopia/tours)
## Description
As we know Ethiopia is one of a great place to visit in the world. there are alot of tourists who came to visit Ethiopia per year. so this application is developed to help tourists.Tour Ethiopia will showcase tourist destinations in Ethiopia so that the tourists will have the awareness of where to go and also they will pick hotels around there. You can checkout destinations and get additional info about them. lets explore Ethiopia!
```
class FirstActivity : AppCompatActivity() {
    var SPLASH_TIME = 4000 //This is 4 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Handler().postDelayed({
            val i = Intent(this@FirstActivity, MainActivity::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, SPLASH_TIME.toLong()) // wait for 4 seconds
    }
}
```
