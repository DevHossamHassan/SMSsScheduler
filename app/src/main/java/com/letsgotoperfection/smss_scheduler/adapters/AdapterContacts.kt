package com.letsgotoperfection.smss_scheduler.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.letsgotoperfection.smss_scheduler.R
import com.letsgotoperfection.smss_scheduler.models.Contact
import io.realm.RealmResults
import kotlinx.android.synthetic.main.item_contacts.view.*

/**
 * @author hossam.
 */
class AdapterContacts(contacts: RealmResults<Contact>) : RecyclerView.Adapter<AdapterContacts.ViewHolder>() {
    val mItems: MutableList<Contact>

    init {
        mItems = contacts
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_contacts, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mItems[position]

        holder.contactName.text = item.name
        holder.contactNumber.text = item.phone

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName = view.tvContactName
        val contactNumber = view.tvContactNumber
    }

}