echo off

echo "***************************************"
echo "*****       INFO PC GLOBAL        *****"
echo "***************************************"

uname -a > datos_pc.md
lsb_release -a >> datos_pc.md
lshw -short >> datos_pc.md
free -h >> datos_pc.md
df -h >> datos_pc.md

echo "¶¶¶¶¶¶¶¶¶¶¶¶¶  LISTO  ¶¶¶¶¶¶¶¶¶¶¶¶¶¶"
