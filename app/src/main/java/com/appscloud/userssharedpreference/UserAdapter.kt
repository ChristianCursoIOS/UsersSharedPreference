package com.appscloud.userssharedpreference

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appscloud.userssharedpreference.databinding.ItemUserBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

//la constante user que esta en los parentesis propiedad que sirve para recibir eeste listado de objetos

//1 Creamo una clase adapter la cual recibe un listado de usuarios que podria ser de cualquier tipo
// de objeto,
//2 heredamos de una clase viewHolder que viene de recyclerView Adapter pero esa clase la creamos
// es personalizada y esta dentro del Adapter UserAdapter es una clase interna (inner) donde
// vinculamos nuestra vista y para lograr esto habilitamos viewBinding.


class UserAdapter(private val user: List<Usuario>) :
    RecyclerView.Adapter<UserAdapter.ViewHolderUser>() {

    //con lateinit indicamos que la variable será inicializada después
    private lateinit var context: Context

    //método onCreatViewHolder sirve para inflar la viasta xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return ViewHolderUser(view)
    }

    // para llenar cada celda conla información correspondiente
    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        val user =
            user.get(position)// constante que guarda el indice del objeto user como el for each

        //usamos la funciona de alcance with para alimentar cada propiedad respecto al valor de cada usuario
        with(holder) {
            binding.tvOrder.text = (position + 1).toString()
            binding.tvName.text = user.getFullName()
           // binding.tvName.text = user.name + " " + user.lastName
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)


        }

    }

    //indica cuantos elementos hay en este adapter
    override fun getItemCount(): Int = user.size


    //inner se refiere que es una clase interna
    inner class ViewHolderUser(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemUserBinding.bind(view)// vinculamos la vista view a este adaptador
    }
}