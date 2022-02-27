package com.example.odev6

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.databinding.SandalyeCardTasarimBinding


class SandalyelerAdapter(var mContext : Context, var sandalyelerListesi : List<Sandalyeler>)
    : RecyclerView.Adapter<SandalyelerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(tasarim : SandalyeCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {

        var tasarim : SandalyeCardTasarimBinding

        init {
            this.tasarim = tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SandalyeCardTasarimBinding.inflate(layoutInflater, parent, false)
        return  CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val sandalye =sandalyelerListesi.get(position)
        val t = holder.tasarim

        t.imageViewSandalyeResim.setImageResource(
            mContext.resources.getIdentifier(sandalye.sandalyeResimAdi, "drawable", mContext.packageName)
        )

        t.textViewSandalyeAd.text = sandalye.sandalyeAdi
        t.textViewSandalyeAciklama.text = sandalye.sandalyeAciklama
        t.textViewSandalyeAciklamaIki.text = sandalye.sandalyeAciklamaIki
        t.textViewSandalyeFiyat.text = " ${sandalye.sandalyeFiyat}₺ "



    }

    override fun getItemCount(): Int {
        return sandalyelerListesi.size
    }

}