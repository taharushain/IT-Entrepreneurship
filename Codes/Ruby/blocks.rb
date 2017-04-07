2.times { puts "hello world"}

3.times do |index|
	if index > 0 
		puts index		
	end
end


4.times { |index| puts index if index > 0 }