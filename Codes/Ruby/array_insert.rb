stack  = []
stack << "one"
stack.push "two"

puts stack.pop
p stack

queue = []
queue.push "one"
queue.push "two"
queue.push "three"

p "Queue:"
p queue
puts queue.shift


a  = [3,2,54,1,9]
p a
p a.sort!
p a.reverse!
