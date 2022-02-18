package com.example.rest5;

import javax.persistence.*;

@Entity
@Table(name = "names", schema = "names", catalog = "")
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //sets up for auto increment
    private int id = 0;
    private String name = "";

    public Name() {
        this.id = id;
        this.name = name;
    }

    public Name(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        if (id != name1.id) return false;
        if (name != null ? !name.equals(name1.name) : name1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

