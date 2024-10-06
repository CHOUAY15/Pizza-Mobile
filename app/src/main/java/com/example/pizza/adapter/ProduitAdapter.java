package com.example.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizza.R;
import com.example.pizza.beans.Produit;

import java.util.List;

public class ProduitAdapter  extends BaseAdapter {

    private List<Produit> produits;
    private LayoutInflater inflater;
    private Context context;

    public ProduitAdapter(List<Produit> produits, Activity activity) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = activity;
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.items, null);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView duree = convertView.findViewById(R.id.duree);
        ImageView photo = convertView.findViewById(R.id.photo);
        TextView id = convertView.findViewById(R.id.id);
        TextView nbr = convertView.findViewById(R.id.nbr);
        ImageView partage = convertView.findViewById(R.id.partage);
        final Produit produit = produits.get(position);



        nom.setText(produits.get(position).getNom());
        duree.setText(produits.get(position).getDuree()+"");
        photo.setImageResource(produits.get(position).getPhoto());
        id.setText(produits.get(position).getId()+"");
        nbr.setText(produits.get(position).getNbrIngredient()+"");


        partage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareViaWhatsApp(produit);
            }
        });

        return convertView;
    }
    private void shareViaWhatsApp(Produit produit) {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");

        String message = "Check out this product: " + produit.getNom() +
                "\nDuration: " + produit.getDuree() +
                "\nIngredients: " + produit.getNbrIngredient();

        whatsappIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            context.startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "WhatsApp is not installed on this device.", Toast.LENGTH_SHORT).show();
        }
    }



}
