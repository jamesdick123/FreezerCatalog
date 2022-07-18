package com.jamesdick.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    //constructors
    @Id //essentially primary key
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private int quantity;


    //getters and setters
    public int getId(){ return id; }
    public void setId(int id) {this.id = id; }
    public String getName() { return name; }
    public void setName(String name){ this.name = name; }
    public String getType(){ return type; }
    public void setType(String type){ this.type = type; }
    public int getQuantity(){ return quantity; }
    public void setQuantity(int quantity){ this.quantity = quantity; }

}
