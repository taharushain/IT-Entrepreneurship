File.open("test_write_2.txt", "w") do |file|

	3.times do |index|
		file.puts index
	end

end