#!/usr/bin/env python3

import os
import csv
from typing import Dict, List
import numpy as np # type: ignore
import matplotlib.pyplot as plt # type: ignore

ALGORITHMS = ['t_cubic', 't_quadratic', 't_hashmap']
RESULTS_DIR = 'results'

def read_results(filename: str) -> Dict[str, Dict[int, List[float]]]:
    results: Dict[str, Dict[int, List[float]]] = dict()
    with open(filename, 'r') as f:
        reader = csv.DictReader(f)
        for row in reader:
            algorithm: str = row['algorithm']
            n: int = int(row['n'])
            t: float = float(row['time'])
            if algorithm not in results:
                results[algorithm] = dict()
            if n not in results[algorithm]:
                results[algorithm][n] = list()
            results[algorithm][n].append(t)
    return results

def compute_mean_std(raw: Dict[int, List[float]]) -> np.ndarray:
    result = np.zeros((len(raw), 3))
    for i, n in enumerate(sorted(raw)):
        result[i,0] = n
        result[i,1] = np.mean(raw[n])
        result[i,2] = np.std(raw[n], ddof=1)
    return result

def write_latex_tabular(res: np.ndarray, filename: str):
    with open(filename, 'w') as f:
        f.write(r'\begin{tabular}{rrr}' + '\n')
        f.write(r'$n$ & Average (s) & ' + \
            'Standard deviation (s)')
        f.write(r'\\\hline' + '\n')
        for i in range(res.shape[0]):
            fields = [str(int(res[i, 0])),
                f'{res[i,1]:.6f}',
                f'{res[i,2]:.6f}']
            f.write(' & '.join(fields) + r'\\'+'\n')
        f.write(r'\end{tabular}' + '\n')

def plot_algorithms(res: Dict[str, np.ndarray], filename: str):
    (fig, ax) = plt.subplots()
    for algorithm in ALGORITHMS:
        ns = res[algorithm][:,0]
        means = res[algorithm][:,1]
        stds = res[algorithm][:,2]
        ax.errorbar(ns, means, stds, marker='o', capsize = 3.0)
    ax.set_xlabel('Number of elements $n$')
    ax.set_ylabel('Time (s)')
    ax.set_xscale('log')
    ax.set_yscale('log')

    ax.legend(ALGORITHMS)

    fig.savefig(RESULTS_DIR+"/"+filename)

if __name__ == '__main__':
    raw_results: Dict[str, Dict[int, List[float]]] = read_results('results/results.csv')
    refined_results: Dict[str, np.ndarray] = dict()
    for algorithm in raw_results:
        refined_results[algorithm] = compute_mean_std(raw_results[algorithm])

    # Generate results folder, if not already available
    if not os.path.exists(RESULTS_DIR):
        os.makedirs(RESULTS_DIR)

    # Generate a LaTeX table for each algorithm
    for algorithm in ALGORITHMS:
        write_latex_tabular(refined_results[algorithm], f"{RESULTS_DIR}/threesum_{algorithm}_tabular.tex")

    # Generate a plot of results
    plot_algorithms(refined_results, "plot")