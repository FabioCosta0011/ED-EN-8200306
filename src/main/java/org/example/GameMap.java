package org.example;

import org.example.Structures.Implementations.Network;
import java.util.Random;

class GameMap {
    private final Network<Location> locations;

    public GameMap() {
        this.locations = new Network<>();
    }

    public Network<Location> getLocations() {
        return locations;
    }

    public GameMap generateRandomMap(int quantityLocations, boolean bidirectional, double densityEdges) {
        Random random = new Random();

        // Array temporário para armazenar as localizações
        Location[] tempArray = new Location[quantityLocations];

        // Criar localizações aleatórias e adicioná-las à rede e ao array temporário
        for (int i = 0; i < quantityLocations; i++) {
            int randomX = random.nextInt(100);
            int randomY = random.nextInt(100);
            Location newLocation = new Location(i, randomX, randomY);
            locations.addVertex(newLocation);
            tempArray[i] = newLocation;
        }

        // Adicionar arestas entre as localizações com base na densidade
        for (int i = 0; i < quantityLocations; i++) {
            Location location1 = tempArray[i];

            for (int j = i + 1; j < quantityLocations; j++) {
                Location location2 = tempArray[j];

                if (!location1.equals(location2) && random.nextDouble() < densityEdges) {
                    int randomDistance = random.nextInt(15) + 1;
                    locations.addEdge(location1, location2, randomDistance);

                    // Se bidirecional, adicione a aresta de location2 para location1
                    if (bidirectional) {
                        locations.addEdge(location2, location1, randomDistance);
                    }
                }
            }
        }

        return this;
    }

    public void exportMap(String pathFile) {} //A Implementar

    public void importMap(String filePath) {} //A Implementar

    @Override
    public String toString() {
        String result;
        result = this.locations.toString();
        return result.toString();
    }
}

