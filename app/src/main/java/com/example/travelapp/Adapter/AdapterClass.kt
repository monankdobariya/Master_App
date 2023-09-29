package com.example.travelapp.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelapp.Fragment.HomeFragment
import com.example.travelapp.ModelClass.StudentModelClass
import com.example.travelapp.R

class AdapterClass(
    var homefragment: HomeFragment,
    var list: ArrayList<StudentModelClass>,
    var onItemClick: (place: String, Location: String, Rate: String, img: String, key: String) -> Unit
) :
    RecyclerView.Adapter<AdapterClass.Myviewholder>() {

    class Myviewholder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var place: TextView= itemView.findViewById(R.id.palce)
        var Location: TextView= itemView.findViewById(R.id.txtlocation)
        var img : ImageView = itemView.findViewById(R.id.img)
        var Rating:TextView=itemView.findViewById(R.id.txtRating)
        var Like:ImageView=itemView.findViewById(R.id.imgLike)
        var Book_beach: CardView = itemView.findViewById(R.id.Book_beach)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.item_file, parent, false)
        return Myviewholder(View)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        holder.place.text = list[position].palce
        holder.Location.text = list[position].Location
        holder.Rating.text=list[position].Rating
        Glide.with(homefragment).load(list[position].ImageUri).into(holder.img)

        holder.Book_beach.setOnClickListener {
            onItemClick.invoke(
                list[position].palce,
                list[position].Location,
                list[position].Rating,
                list[position].ImageUri,
                list[position].key,
            )
        }

//        holder.Like.setOnClickListener {
//
//            if (sharList[position].status == 1) {
//
//                like.invoke(sharList[position].shyari_id, 0)
//                holder.imglike.setImageResource(R.drawable.like1)
//                sharList[position].status = 0
//            } else {
//                like.invoke(sharList[position].shyari_id, 1)
//                holder.imglike.setImageResource(R.drawable.redlike)
//                sharList[position].status = 1
//            }
//        }

    }
}