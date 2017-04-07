def method_name (&iam_a_block)
	return "No block" if iam_a_block.nil?


	iam_a_block.call
	iam_a_block.call

end


method_name { puts "Hello"}
puts method_name

