package playListManagementSystem;
import playListManagementSystem.controller.SinglyLinkedPlaylistManager;
import playListManagementSystem.model.Song;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO 19: uncomment below code to run Doubly linked list code
        // DoublyLinkedPlaylistManager playlistManager = new  DoublyLinkedPlaylistManager();

        // uncomment below code to run singly linked list code
        SinglyLinkedPlaylistManager playlistManager = new SinglyLinkedPlaylistManager();
        Scanner keyboard = new Scanner(System.in);
        int choice;

        // Predefined list of songs
        Song[] availableSongs = {
                new Song("Blinding Lights", "The Weeknd", 200, "Pop"),
                new Song("Bohemian Rhapsody", "Queen", 354, "Rock"),
                new Song("Take Five", "Dave Brubeck", 324, "Jazz"),
                new Song("Für Elise", "Ludwig van Beethoven", 180, "Classical"),
                new Song("Shape of You", "Ed Sheeran", 233, "Pop"),
                new Song("Hotel California", "Eagles", 391, "Rock"),
                new Song("What a Wonderful World", "Louis Armstrong", 140, "Jazz"),
                new Song("Symphony No. 9", "Beethoven", 1250, "Classical"),
        };

        do {
            System.out.println("\nFavorite Song List Manager");
            System.out.println("1. Add a new song to favorites");
            System.out.println("2. Remove a song from favorites");
            System.out.println("3. Display favorite songs list");
            System.out.println("4. Play next favorite song");
            System.out.println("5. Play previous favorite song");
            System.out.println("6. Start playing from the first favorite song");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = -1;
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                keyboard.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            switch (choice) {
                case 1:
                    // Display the list of available songs
                    System.out.println("Available Songs:");
                    for (int i = 0; i < availableSongs.length; i++) {
                        // Print each song with its corresponding number
                        System.out.println((i + 1) + ". " + availableSongs[i]);
                    }

                    // Prompt the user to enter the number of the song to add
                    System.out.print("Enter the number of the song to add: ");

                    // Read the user's choice as an integer
                    int songChoice = keyboard.nextInt();
                    // Consume the newline character left by nextInt()
                    keyboard.nextLine();

                    // Check if the chosen number is within the valid range
                    if (songChoice >= 1 && songChoice <= availableSongs.length) {
                        // Add the chosen song to the playlist
                        playlistManager.addFavoriteSong(availableSongs[songChoice - 1]);
                    } else {
                        // Inform the user if the choice is invalid
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    if (playlistManager.isEmpty()) {
                        System.out.println("Playlist is empty.");
                    } else {
                        System.out.println("Songs in Playlist:");
                        playlistManager.displayFavoriteSongs();
                        System.out.print("Enter the number of the song to remove: ");
                        int removeIndex = keyboard.nextInt();
                        keyboard.nextLine(); // Consume newline
                        playlistManager.removeFavoriteSong(removeIndex);
                    }
                    break;
                case 3:
                    playlistManager.displayFavoriteSongs();
                    break;
                case 4:
                    playlistManager.playNextFavoriteSong();
                    break;
                case 5:
                    // TODO 20: uncomment this when run the doubly linked list
                    //move to the previous song in the playlist
                     playlistManager.playPreviousFavoriteSong();
                    break;
                case 6:
                    playlistManager.setCurrentToFirst();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 7);

        keyboard.close();
    }
}
