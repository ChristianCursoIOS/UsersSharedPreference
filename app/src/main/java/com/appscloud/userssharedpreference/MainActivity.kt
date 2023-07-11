package com.appscloud.userssharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appscloud.userssharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter //instancia de nuestro adaptador
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager //nos sirve para que sea de una sola columna
    private lateinit var binding: ActivityMainBinding // vincula nuestra vista del recyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inicializamos nuestras variables
        userAdapter = UserAdapter(getUsers())
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    // método que devuelve un arreglo de usuarios
    private fun getUsers(): MutableList<Usuario> {
        val users = mutableListOf<Usuario>() // constante de tipo mutable de usuarios


        val ma = Usuario(1, "Jefa", "Silva", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuk2JXb-FO79N8jsFZgOhxzfUgQOsBZQvNrQ&usqp=CAU")
        val pa = Usuario(2, "Pap", "Escobar", "https://freesvg.org/img/Linux-Avatar.png")
        val uli = Usuario(3, "Ulises", "Escobar", "https://upload.wikimedia.org/wikipedia/commons/9/91/Boki-avatar.jpg")
        val chita = Usuario(4, "Monse", "Serralde", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpH4E-GegRW32g1O46sgtfM9Q9rf3AcHkURw&usqp=CAU")
        val chr = Usuario(5, "Christian", "Escobar", "https://freesvg.org/img/Happy-Penguin-Avatar.png")


        users.add(ma)
        users.add(pa)
        users.add(uli)
        users.add(chita)
        users.add(chr)
        users.add(ma)
        users.add(pa)
        users.add(uli)
        users.add(chita)
        users.add(chr)
        users.add(ma)
        users.add(pa)
        users.add(uli)
        users.add(chita)
        users.add(chr)
        users.add(ma)
        users.add(pa)
        users.add(uli)
        users.add(chita)
        users.add(chr)




        return users

    }
}