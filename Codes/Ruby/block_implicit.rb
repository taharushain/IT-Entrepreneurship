def method_name
	return "No block" unless block_given?

	yield
	yield
	yield
	
end


puts method_name { puts "Hello"}

puts method_name