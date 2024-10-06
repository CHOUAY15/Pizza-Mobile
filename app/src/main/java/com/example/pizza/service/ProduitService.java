package com.example.pizza.service;

import android.util.Log;

import com.example.pizza.beans.Produit;
import com.example.pizza.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private List<Produit> produits;

    public ProduitService(List<Produit> produits) {
        this.produits = produits;
    }
    public ProduitService() {
        this.produits = new ArrayList<>();
    }


    @Override
    public boolean create(Produit produit) {
        Log.d("produit created :",produit.toString());
       return produits.add(produit);

    }

    @Override
    public boolean update(Produit produit) {
        Log.d("produit updated :",produit.toString());
        Produit p=findById(produit.getId());
        if (p!=null){
            p.setPhoto(produit.getPhoto());
            p.setDescription(produit.getDescription());
            p.setDuree(produit.getDuree());
            p.setNom(produit.getNom());
            p.setPreparation(produit.getPreparation());
            p.setNbrIngredient(produit.getNbrIngredient());
            p.setDetaisIngred(produit.getDetaisIngred());
            return  true;
        }
        return false;
    }

    @Override
    public boolean delete(Produit produit) {
        Log.d("produit deleted :",produit.toString());
       return produits.remove(produit);
    }

    @Override
    public List<Produit> findAll() {
        Log.d("produits  :",produits.size()+"");
        return  produits;
    }

    @Override
    public Produit findById(int id) {
        Log.d("produit  :",id+"");
        for (Produit produit:produits) {
            if(produit.getId()==id){
                return produit;
            }

        }
        return  null;
    }
}
