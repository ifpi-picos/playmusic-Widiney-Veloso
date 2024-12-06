import dominio.Musica;
import dominio.Album;
import dominio.Artista;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {
    public static String musicName = "In-The-End-Linkin-Park";
        public static void main(String[] args) throws Exception {
            // var musicName = "In-The-End-Linkin-Park";
    
    
            //Criação de músicas
            Musica musica1 = new Musica("In-The-End-Linkin-Park", 216, "assets\\In-The-End-Linkin-Park.wav", "Rock");
            Musica musica2 = new Musica("Red-Hot-Chili-Peppers-Californication", 329, "assets\\Red-Hot-Chili-Peppers-Californication.wav", "Rock");
            Musica musica3 = new Musica("Red-Hot-Chili-Peppers-Otherside", 255, "assets\\Red-Hot-Chili-Peppers-Otherside.wav", "Rock");
    
    
            //Criando album e adicionando músicas no album
            Album album1 = new Album();
            album1.setNome("RedHot");
            album1.addMusica(musica1);
            album1.addMusica(musica2);
            album1.addMusica(musica3);
    
    
            //Criando o Artista e adicionando o album a para ele
            Artista RedHot = new Artista();
            RedHot.setNome("RedHot");
            RedHot.addAlbum(album1);
    
    
            //Criando audio player
            AudioPlayer player = new AudioPlayer(album1);
            player.loadAudio(musica1.getArquivoAudio());
    
            
            //Criação de botões
            JButton prevButton = new JButton("Back");
            JButton playStopButton = new JButton("Play");
            JButton nextButton = new JButton("Next");
    
    
            //Ação de botôes play/stop
            playStopButton.addActionListener(e -> {
                if (player.isPlaying){
                    System.out.println("playAudio start");
                    player.stopAudio();
                    playStopButton.setText("Play");
                } else {
                    System.out.println("playAudio stop");
                    player.playAudio();
                    playStopButton.setText("Stop");
                }
            });
    
            //Ação botão next
            nextButton.addActionListener(e -> {
                player.nextTrack();
                playStopButton.setText("Stop");
            });


        //Ação botan Prev
        prevButton.addActionListener(e -> {
            player.prevTrack();
            playStopButton.setText("Stop"); 
        });


        //Criação de interface gráfica
        ImageIcon icon = new ImageIcon("assets\\music.png");
        JOptionPane.showOptionDialog(
            null,
            player.musicName,
            "Musicas",
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.PLAIN_MESSAGE,
            icon,
            new Object[]{prevButton, playStopButton, nextButton}, 
            nextButton);
    }
}