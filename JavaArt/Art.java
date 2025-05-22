import java.util.Arrays;

public class Art {
    private String[][] simbols;
    private final int tamanho_indice;
    public int objDimensao;
    private boolean modoOculto;

    public Art(int dimensao) {
        this.setObjDimensao(dimensao);
        this.simbols = new String[2][this.getObjDimensao()];
        this.setModoOculto(false);
        this.tamanho_indice = this.simbols[0].length - 1;
        for (String[] pos : simbols) Arrays.fill(pos, ": ");
    }

    private void setObjDimensao(int dimensao) {
        if (dimensao < 2 || dimensao > 30) {
            dimensao = 0;
            Msgs msg = new Msgs();
            msg.info();
        }
        this.objDimensao = dimensao;
    }

    private byte getObjDimensao() {
        return (byte) this.objDimensao;
    }

    private void setModoOculto(boolean oculto) {
        this.modoOculto = oculto;
    }

    public boolean isModoOculto() {
        return modoOculto;
    }

    public void construirEmCima() {
        // Construção da parte superior do objeto
        if (this.getObjDimensao() >= 2 && this.getObjDimensao() <= 30) {
            if (this.isModoOculto()) {
                for (String[] pos : simbols) Arrays.fill(pos, "  ");
            } else {
                for (String[] pos : this.simbols) {
                    for (String obj : pos) {
                        System.out.print(obj);
                    }
                }
            }
            System.out.println();

            var i = 0;
            do {
                this.simbols[0][this.tamanho_indice - i] = " *  ";
                this.simbols[1][this.tamanho_indice - i] = "  ";
                i++;

                for (String[] pos : this.simbols) {
                    for (String obj : pos) {
                        System.out.print(obj);
                    }
                }
                System.out.println();
            } while (i <= this.tamanho_indice);
            for (String[] pos : simbols) Arrays.fill(pos, ": ");
        }
    }

    public void construirEmBaixo() {
        // Construção da parte inferior do objeto
        if (this.getObjDimensao() >= 2 && this.getObjDimensao() <= 30) {
            Arrays.fill(this.simbols[0], " *  ");
            Arrays.fill(this.simbols[1], "  ");

            var i = 0;
            do {
                if (!this.isModoOculto()) {
                    this.simbols[0][i] = ": ";
                    this.simbols[1][i] = ": ";
                } else {
                    this.simbols[0][i] = "  ";
                    this.simbols[1][i] = "  ";
                }

                for (String[] pos : this.simbols) {
                    for (String obj : pos) {
                        System.out.print(obj);
                    }
                }
                System.out.println();
                i++;
            } while (i <= this.tamanho_indice);
        }
    }

    public void ocultarBackground() {
        /* Este método ocultará o "background" quando for
        mostrado na tela, assim que for invocado */
        if (!this.isModoOculto()) {
            this.setModoOculto(true);
            for (String[] pos : simbols) Arrays.fill(pos, "  ");
        }
    }

    public void mostrarBackground() {
       /* Este método mostrará novamente o "background"
       OBS: Por padrão, o "background" já é explícito */
        if (this.isModoOculto()) {
            this.setModoOculto(false);
            for (String[] pos : simbols) Arrays.fill(pos, ": ");
        }
    }
}
