a = [1,3,4,7,8,10]

a.each { |num| p num}


new_arr = a.select { |num| num > 4}
p new_arr

new_arr_reject = a.reject { |num| num > 4}
p new_arr_reject

new_arr_map = a.map{ |num| num * 3}
p new_arr_map