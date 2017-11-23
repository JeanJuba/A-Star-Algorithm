/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author m95952
 */
public class AStarAlg {

    private Map<Integer, Cidade> mapaCidades = new HashMap();
    private List<Node> abertos;
    private List<Node> fechados;

    private final int START = 1;
    private final int DESTINO = 38;

    public AStarAlg() {
        abertos = new ArrayList<>();
        fechados = new ArrayList<>();

        Node firstNode = new Node(null);
        firstNode.setCidadeId(START);
        firstNode.setValodG(0);
        firstNode.setValorH(funcaoAvaliacaoAtualFim());
        firstNode.setValorF(firstNode.getValodG() + firstNode.getValorH());

        abertos.add(firstNode);
        Criar_mapa(); //Cria o mapa com as informações fornecidas
    }

    //<editor-fold defaultstate="collapsed" desc="Criacão Mapa">
    private void Criar_mapa() {
        mapaCidades.put(1, new Cidade(11003.611100f, 42102.500000f));
        mapaCidades.put(2, new Cidade(11108.611100f, 42373.888900f));
        mapaCidades.put(3, new Cidade(11133.333300f, 42885.833300f));
        mapaCidades.put(4, new Cidade(11155.833300f, 42712.500000f));
        mapaCidades.put(5, new Cidade(11183.333300f, 42933.333300f));
        mapaCidades.put(6, new Cidade(11297.500000f, 42853.333300f));
        mapaCidades.put(7, new Cidade(11310.277800f, 42929.444400f));
        mapaCidades.put(8, new Cidade(11416.666700f, 42983.333300f));
        mapaCidades.put(9, new Cidade(11423.888900f, 43000.277800f));
        mapaCidades.put(10, new Cidade(11438.333300f, 42057.222200f));
        mapaCidades.put(11, new Cidade(11461.111100f, 43252.777800f));
        mapaCidades.put(12, new Cidade(11485.555600f, 43187.222200f));
        mapaCidades.put(13, new Cidade(11503.055600f, 42855.277800f));
        mapaCidades.put(14, new Cidade(11511.388900f, 42106.388900f));
        mapaCidades.put(15, new Cidade(11522.222200f, 42841.944400f));
        mapaCidades.put(16, new Cidade(11569.444400f, 43136.666700f));
        mapaCidades.put(17, new Cidade(11583.333300f, 43150.000000f));
        mapaCidades.put(18, new Cidade(11595.000000f, 43148.055600f));
        mapaCidades.put(19, new Cidade(11600.000000f, 43150.000000f));
        mapaCidades.put(20, new Cidade(11690.555600f, 42686.666700f));
        mapaCidades.put(21, new Cidade(11715.833300f, 41836.111100f));
        mapaCidades.put(22, new Cidade(11751.111100f, 42814.444400f));
        mapaCidades.put(23, new Cidade(11770.277800f, 42651.944400f));
        mapaCidades.put(24, new Cidade(11785.277800f, 42884.444400f));
        mapaCidades.put(25, new Cidade(11822.777800f, 42673.611100f));
        mapaCidades.put(26, new Cidade(11846.944400f, 42660.555600f));
        mapaCidades.put(27, new Cidade(11963.055600f, 43290.555600f));
        mapaCidades.put(28, new Cidade(11973.055600f, 43026.111100f));
        mapaCidades.put(29, new Cidade(12058.333300f, 42195.555600f));
        mapaCidades.put(30, new Cidade(12149.444400f, 42477.500000f));
        mapaCidades.put(31, new Cidade(12286.944400f, 43355.555600f));
        mapaCidades.put(32, new Cidade(12300.000000f, 42433.333300f));
        mapaCidades.put(33, new Cidade(12355.833300f, 43156.388900f));
        mapaCidades.put(34, new Cidade(12363.333300f, 43189.166700f));
        mapaCidades.put(35, new Cidade(12372.777800f, 42711.388900f));
        mapaCidades.put(36, new Cidade(12386.666700f, 43334.722200f));
        mapaCidades.put(37, new Cidade(12421.666700f, 42895.555600f));
        mapaCidades.put(38, new Cidade(12645.000000f, 42973.333300f));
        add_nodo(1, 2);
        add_nodo(1, 4);
        add_nodo(1, 10);
        add_nodo(1, 15);
        add_nodo(1, 17);
        add_nodo(2, 16);
        add_nodo(2, 3);
        add_nodo(2, 7);
        add_nodo(2, 10);
        add_nodo(2, 11);
        add_nodo(3, 12);
        add_nodo(3, 18);
        add_nodo(3, 28);
        add_nodo(3, 27);
        add_nodo(3, 29);
        add_nodo(4, 11);
        add_nodo(4, 19);
        add_nodo(4, 22);
        add_nodo(4, 13);
        add_nodo(4, 14);
        add_nodo(4, 6);
        add_nodo(4, 16);
        add_nodo(5, 27);
        add_nodo(5, 29);
        add_nodo(5, 30);
        add_nodo(6, 31);
        add_nodo(6, 33);
        add_nodo(6, 34);
        add_nodo(6, 17);
        add_nodo(6, 8);
        add_nodo(7, 8);
        add_nodo(7, 9);
        add_nodo(7, 10);
        add_nodo(7, 38);
        add_nodo(7, 3);
        add_nodo(7, 26);
        add_nodo(7, 13);
        add_nodo(7, 37);
        add_nodo(8, 4);
        add_nodo(8, 7);
        add_nodo(8, 15);
        add_nodo(8, 17);
        add_nodo(8, 25);
        add_nodo(8, 29);
        add_nodo(8, 28);
        add_nodo(8, 34);
        add_nodo(8, 35);
        add_nodo(9, 37);
        add_nodo(9, 23);
        add_nodo(9, 21);
        add_nodo(9, 11);
        add_nodo(10, 21);
        add_nodo(10, 23);
        add_nodo(10, 24);
        add_nodo(10, 38);
        add_nodo(10, 22);
        add_nodo(10, 17);
        add_nodo(11, 5);
        add_nodo(11, 4);
        add_nodo(11, 2);
        add_nodo(12, 1);
        add_nodo(12, 19);
        add_nodo(12, 29);
        add_nodo(12, 27);
        add_nodo(12, 26);
        add_nodo(12, 36);
        add_nodo(12, 34);
        add_nodo(13, 33);
        add_nodo(13, 32);
        add_nodo(13, 23);
        add_nodo(13, 26);
        add_nodo(13, 26);
        add_nodo(13, 28);
        add_nodo(13, 19);
        add_nodo(13, 21);
        add_nodo(14, 7);
        add_nodo(14, 6);
        add_nodo(14, 3);
        add_nodo(14, 2);
        add_nodo(14, 9);
        add_nodo(15, 10);
        add_nodo(15, 11);
        add_nodo(15, 14);
        add_nodo(16, 16);
        add_nodo(16, 23);
        add_nodo(17, 34);
        add_nodo(17, 33);
        add_nodo(17, 37);
        add_nodo(17, 38);
        add_nodo(18, 21);
        add_nodo(18, 20);
        add_nodo(18, 19);
        add_nodo(19, 17);
        add_nodo(19, 16);
        add_nodo(19, 2);
        add_nodo(19, 8);
        add_nodo(20, 14);
        add_nodo(20, 3);
        add_nodo(20, 2);
        add_nodo(20, 6);
        add_nodo(21, 5);
        add_nodo(21, 11);
        add_nodo(21, 16);
        add_nodo(21, 22);
        add_nodo(22, 28);
        add_nodo(23, 26);
        add_nodo(24, 32);
        add_nodo(24, 31);
        add_nodo(25, 27);
        add_nodo(26, 29);
        add_nodo(26, 30);
        add_nodo(26, 20);
        add_nodo(27, 10);
        add_nodo(27, 22);
        add_nodo(27, 23);
        add_nodo(27, 7);
        add_nodo(28, 9);
        add_nodo(28, 12);
        add_nodo(28, 15);
        add_nodo(29, 19);
        add_nodo(29, 20);
        add_nodo(29, 22);
        add_nodo(30, 11);
        add_nodo(30, 23);
        add_nodo(30, 29);
        add_nodo(30, 12);
        add_nodo(31, 23);
        add_nodo(31, 33);
        add_nodo(32, 27);
        add_nodo(32, 17);
        add_nodo(32, 14);
        add_nodo(32, 16);
        add_nodo(33, 16);
        add_nodo(33, 2);
        add_nodo(33, 7);
        add_nodo(33, 8);
        add_nodo(33, 9);
        add_nodo(34, 10);
        add_nodo(34, 9);
        add_nodo(34, 15);
        add_nodo(34, 28);
        add_nodo(34, 38);
        add_nodo(35, 27);
        add_nodo(35, 23);
        add_nodo(35, 32);
        add_nodo(35, 12);
        add_nodo(35, 11);
        add_nodo(35, 8);
        add_nodo(36, 6);
        add_nodo(36, 23);
        add_nodo(36, 34);
        add_nodo(36, 33);
        add_nodo(36, 2);
        add_nodo(36, 37);
        add_nodo(37, 25);
        add_nodo(37, 23);
        add_nodo(37, 12);
        add_nodo(37, 9);
        add_nodo(38, 23);
        add_nodo(38, 15);
        add_nodo(38, 18);
        add_nodo(38, 22);
    }

    private void add_nodo(int id1, int id2) {
        mapaCidades.get(id1).ad_vertice(id2);
    }
    //</editor-fold>

    public class Cidade {

        private float x;
        private float y;
        private List<Integer> conexoes;

        public Cidade(float x, float y) {
            this.x = x;
            this.y = y;
            this.conexoes = new ArrayList();
        }

        public void ad_vertice(int c) {
            this.conexoes.add(c);
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public List<Integer> getConexoes() {
            return conexoes;
        }
    }

    public class Node {

        private int cidadeId; //Id da cidde a qual se refere
        private double valodG; //Valor de custo para chegar até o nó
        private double valorH; //Valor deste nó ate o nó final
        private double valorF; //Avaliação global G + H do nó

        private Node parent;
        private List<Node> sucessores;

        public Node(Node _parent) {
            this.parent = _parent;
            this.sucessores = new ArrayList<>();
        }

        public int getCidadeId() {
            return cidadeId;
        }

        public void setCidadeId(int cidadeId) {
            this.cidadeId = cidadeId;
        }

        public double getValodG() {
            return valodG;
        }

        public void setValodG(double valodG) {
            this.valodG = valodG;
        }

        public double getValorH() {
            return valorH;
        }

        public void setValorH(double valorH) {
            this.valorH = valorH;
        }

        public double getValorF() {
            return valorF;
        }

        public void setValorF(double valorF) {
            this.valorF = valorF;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void addSucessor(Node sucessor) {
            this.sucessores.add(sucessor);
        }

        public List<Node> getSucessores() {
            return sucessores;
        }
    }

    public void startAlgorithm() {
        while (!abertos.isEmpty()) {
            Node n = menorValorAberto();
            if (n.getCidadeId() == DESTINO) {
                encontrarCaminho(n);
                break;
            } else {
                gerarSucessores(n);

            }
        }

        

    }

    private Node menorValorAberto() {
        Node node = abertos.get(0);

        for (Node n : abertos) {
            if (n.getValorF() < node.getValorF()) {
                node = n;
            }
        }
        abertos.remove(node);
        fechados.add(node);

        return node;
    }

    private Node gerarSucessores(Node bestNode) {
        for (int i : mapaCidades.get(bestNode.getCidadeId()).getConexoes()) {
            Node n = new Node(bestNode);
            n.setCidadeId(i);
            n.setValodG(bestNode.getValodG() + getDistance(bestNode.getCidadeId(), i));

            if (isAberto(n.getCidadeId()) != null) {
                Node nodoAntigo = isAberto(n.getCidadeId());

                if (nodoAntigo.getValodG() > n.getValodG()) {
                    nodoAntigo.setParent(bestNode);
                    nodoAntigo.setValodG(n.getValodG());
                    nodoAntigo.setValorF(nodoAntigo.getValodG() + nodoAntigo.getValorH());
                }

                bestNode.addSucessor(nodoAntigo);

            } else {
                if (isFechado(n.getCidadeId()) != null) {
                    Node nodoAntigo = isFechado(n.getCidadeId());

                    if (nodoAntigo.getValodG() > n.getValodG()) {
                        nodoAntigo.setParent(bestNode);
                        nodoAntigo.setValodG(n.getValodG());
                        nodoAntigo.setValorF(nodoAntigo.getValodG() + nodoAntigo.getValorH());
                        
                        for(Node no: nodoAntigo.getSucessores()){
                            spreadNewBest(no, nodoAntigo.getValodG());
                        }
                    }
                    
                    bestNode.addSucessor(nodoAntigo);

                } else {
                    n.setValorF(n.getValodG() + n.getValorH());
                    abertos.add(n);
                    bestNode.addSucessor(n);
                    
                }

            }

        }

        return bestNode;
    }

    private void spreadNewBest(Node n, double valorG){
        n.setValodG(valorG + getDistance(n.getCidadeId(), n.getParent().getCidadeId()));
        for(Node no: n.getSucessores()){
            spreadNewBest(no, n.getValodG());
        }
        
    }
    
    /**
     * Retorna a distância euclidiana entre duas cidades.
     * @param idCidade1
     * @param idCidade2
     * @return distância
     */
    private double getDistance(int idCidade1, int idCidade2) {
        double c1x = mapaCidades.get(idCidade1).getX();
        double c1y = mapaCidades.get(idCidade1).getY();
        double c2x = mapaCidades.get(idCidade2).getX();
        double c2y = mapaCidades.get(idCidade2).getY();

        double distX = Math.abs(c1x - c2x);
        double distY = Math.abs(c1y - c2y);

        double distancia = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));

        return distancia;
    }

    /**
     * Verifica se o nó já está na lista ABERTOS e se estiver retorna o nó 
     * como 
     * @param id
     * @return 
     */
    private Node isAberto(int id) {
        for (Node n : abertos) {
            if (n.getCidadeId() == id) {
                return n;
            }
        }
        return null;
    }

    private Node isFechado(int id) {
        for (Node n : fechados) {
            if (n.getCidadeId() == id) {
                return n;
            }
        }
        return null;
    }

    private double funcaoAvaliacaoInicialAtual() {
        return 0;
    }

    private double funcaoAvaliacaoAtualFim() {
        return 0;
    }

    private void encontrarCaminho(Node n) {
        
        while(n.getParent() !=  null){
            System.out.println("Cidade: " + n.getCidadeId());
            n = n.getParent();
        }
        
    }
}
