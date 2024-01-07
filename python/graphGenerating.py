import pandas as pd
import matplotlib.pyplot as plt

# modifier le path si jamais vous recompiler.. 
file_path = '/Users/charleskandarakis/Local/Code_A23/INF2010/tp5-gr02-2204548_2179269/maze_results.csv'

data = pd.read_csv(file_path)

plt.figure(figsize=(15, 10))

# Graphique pour la longueur du chemin
plt.subplot(2, 2, 1)
plt.plot(data['ProblemNumber'], data['BFS_PathLength'], label='BFS Path Length')
plt.plot(data['ProblemNumber'], data['DFS_PathLength'], label='DFS Path Length')
plt.title('Path Length Comparison')
plt.xlabel('Problem Number')
plt.ylabel('Path Length')
plt.legend()

# Graphique pour le nombre total de nœuds traversés
plt.subplot(2, 2, 2)
plt.plot(data['ProblemNumber'], data['BFS_NodesTraversed'], label='BFS Nodes Traversed')
plt.plot(data['ProblemNumber'], data['DFS_NodesTraversed'], label='DFS Nodes Traversed')
plt.title('Nodes Traversed Comparison')
plt.xlabel('Problem Number')
plt.ylabel('Nodes Traversed')
plt.legend()

# Graphique pour le nombre maximal de nœuds ajoutés à la pile/file
plt.subplot(2, 2, 3)
plt.plot(data['ProblemNumber'], data['BFS_MaxStackSize'], label='BFS Max Stack Size')
plt.plot(data['ProblemNumber'], data['DFS_MaxStackSize'], label='DFS Max Stack Size')
plt.title('Max Stack Size Comparison')
plt.xlabel('Problem Number')
plt.ylabel('Max Stack Size')
plt.legend()

output_path = '/Users/charleskandarakis/Local/Code_A23/INF2010/tp5-gr02-2204548_2179269/python/maze_graphs.png'
plt.savefig(output_path)

plt.tight_layout()
plt.show()
