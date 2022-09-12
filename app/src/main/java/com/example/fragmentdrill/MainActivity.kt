package com.example.fragmentdrill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val currentFragment = supportFragmentManager.findFragmentById(R.id.frgment_container)//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Создаем переменную fragmentManager и присваивем  ей адрес хостинга фрагментов(место, куда будут
        //погружаться наши фрагменты
        if (currentFragment == null) { // Проверяем создан ли фрагмент, если нет создаем
            val fragment = MainFragment() //Создание КОНКРЕТНОГО фрагмента
            supportFragmentManager.beginTransaction() //Отображение созданного фрагмента
                .add(R.id.frgment_container, fragment)
                .commit()
        }
    }

    fun onClick(view: View) {
        val fragment = TestFragment(getLayoutFragment(view.id)) //Создание КОНКРЕТНОГО фрагмента
        supportFragmentManager.beginTransaction() //Отображение созданного фрагмента
            .replace(R.id.frgment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun getLayoutFragment(idFragment: Int): Int {
        var fragment: Int = 0
        when (idFragment) {
            R.id.frg -> fragment = R.layout.fragment
            R.id.frg1 -> fragment = R.layout.fragment1
            R.id.frg2 -> fragment = R.layout.fragment2
            R.id.frg3 -> fragment = R.layout.fragment3
            R.id.frg4 -> fragment = R.layout.fragment4
            R.id.frg5 -> fragment = R.layout.fragment5
            R.id.frg6 -> fragment = R.layout.fragment6
            R.id.frg7 -> fragment = R.layout.fragment7
            R.id.frg8 -> fragment = R.layout.fragment8
        }
        return fragment
    }
}