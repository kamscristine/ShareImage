package br.ifmg.edu.bsi.progmovel.shareimage1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;

/**
 * Cria um meme com um texto e uma imagem de fundo.
 *
 * Você pode controlar o texto, a cor do texto e a imagem de fundo.
 */
public class MemeCreator {
    private String texto;
    private String texto2;
    private int corTexto;
    private int corTexto2;
    private Bitmap fundo;
    private DisplayMetrics displayMetrics;
    private Bitmap meme;
    private float fonte;
    private float fonte2;
    private boolean dirty; // se true, significa que o meme precisa ser recriado.

    public MemeCreator(String texto, String texto2, int corTexto, int corTexto2, Bitmap fundo, DisplayMetrics displayMetrics, float fonte, float fonte2) {
        this.texto = texto;
        this.texto2 = texto2;
        this.corTexto = corTexto;
        this.corTexto2 = corTexto2;
        this.fundo = fundo;
        this.displayMetrics = displayMetrics;
        this.meme = criarImagem();
        this.dirty = true;
        this.fonte = fonte;
        this.fonte2 = fonte2;
    }

    public float getFonte() { return fonte; }

    public void setFonte(float fonte) {
        this.fonte = fonte;
        dirty = true;
    }

    public float getFonte2() { return fonte2; }

    public void setFonte2(float fonte2) {
        this.fonte2 = fonte2;
        dirty = true;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
        dirty = true;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
        dirty = true;
    }

    public int getCorTexto() {
        return corTexto;
    }

    public void setCorTexto(int corTexto) {
        this.corTexto = corTexto;
        dirty = true;
    }

    public int getCorTexto2() {
        return corTexto2;
    }

    public void setCorTexto2(int corTexto2) {
        this.corTexto2 = corTexto2;
        dirty = true;
    }

    public Bitmap getFundo() {
        return fundo;
    }

    public void setFundo(Bitmap fundo) {
        this.fundo = fundo;
        dirty = true;
    }

    public void rotacionarFundo(float graus) {
        Matrix matrix = new Matrix();
        matrix.postRotate(graus);
        fundo = Bitmap.createBitmap(fundo, 0, 0, fundo.getWidth(), fundo.getHeight(), matrix, true);
        dirty = true;
    }

    public Bitmap getImagem() {
        if (dirty) {
            meme = criarImagem();
            dirty = false;
        }
        return meme;
    }


    protected Bitmap criarImagem() {
        float heightFactor = (float) fundo.getHeight() / fundo.getWidth();
        int width = displayMetrics.widthPixels;
        int height = (int) (width * heightFactor);
        // nao deixa a imagem ocupar mais que 60% da altura da tela.
        if (height > displayMetrics.heightPixels * 0.6) {
            height = (int) (displayMetrics.heightPixels * 0.6);
            width = (int) (height * (1 / heightFactor));
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        Paint paint2 = new Paint();

        Bitmap scaledFundo = Bitmap.createScaledBitmap(fundo, width, height, true);
        canvas.drawBitmap(scaledFundo, 0, 0, new Paint());

        paint.setColor(corTexto);
        paint2.setColor(corTexto2);

        paint.setAntiAlias(true);
        paint2.setAntiAlias(true);

        paint.setTextSize(fonte);
        paint2.setTextSize(fonte2);

        paint.setTypeface(Typeface.create("sans-serif-condensed", Typeface.BOLD));
        paint.setTextAlign(Paint.Align.CENTER);

        paint2.setTypeface(Typeface.create("sans-serif-condensed", Typeface.BOLD));
        paint2.setTextAlign(Paint.Align.CENTER);

        // desenhar texto em cima
        canvas.drawText(texto2, (width / 2.f), (height * 0.15f), paint2);

        // desenhar texto embaixo
        canvas.drawText(texto, (width / 2.f), (height * 0.9f), paint);
        return bitmap;
    }
}
