/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilistas;

/**
 *
 * @author JuanS
 */
public class Nodo {
    Nodo link;
    Subnodo subroot;
    int info;

    public Nodo(Nodo link, Subnodo subroot, int info) {
        this.link = link;
        this.subroot = subroot;
        this.info = info;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    public Subnodo getSubroot() {
        return subroot;
    }

    public void setSubroot(Subnodo subroot) {
        this.subroot = subroot;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
    
}
