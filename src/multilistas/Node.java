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
public class Node {
    Node link;
    Subnode subroot;
    int info;

    public Node(Node link, Subnode subroot, int info) {
        this.link = link;
        this.subroot = subroot;
        this.info = info;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Subnode getSubroot() {
        return subroot;
    }

    public void setSubroot(Subnode subroot) {
        this.subroot = subroot;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
    
}
