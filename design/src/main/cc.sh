#!/bin/bash
#复制目录，并进行转码
function getdir(){
    for element in `ls $1`
    do  
        dir_or_file=$1"/"$element
        if [ -d $dir_or_file ]
        then
            mkdir -p ${outpath}"/"${dir_or_file}
            getdir $dir_or_file
        else
            iconv -f gbk -t utf-8 $dir_or_file > ${outpath}"/"${dir_or_file}
        fi  
    done
}
#文件所在的根目录
root_dir="/Users/malin/malin_review/new/develop/EffectiveJava/design/src/main/java/"
outpath="/Users/malin/malin_review/new/develop/EffectiveJava/design/src/main/utf8"
getdir $root_dir

#移动目录并删除
mv $outpath $outpath
#rm -rf $outpath"/Users"

echo "OK"
