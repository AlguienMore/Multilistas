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
public class Subnode {
    int info;
    Subnode link;

    public Subnode(int info, Subnode link) {
        this.info = info;
        this.link = link;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Subnode getLink() {
        return link;
    }

    public void setLink(Subnode link) {
        this.link = link;
    }
    
    
}
