set terminal png
set output "gcutil.png"
set timefmt "%H:%M"
set grid
set size 1,1
set origin 0,0
set ylabel 'utilization %'
set xlabel 'data points'
set yr [0:100]
set xr [0:200]
plot "gcutil" using 0:3 title 'NG' with line , "gcutil" using 0:4 title 'OG' with line , "gcutil" using 0:5 title 'Perm' with line;
