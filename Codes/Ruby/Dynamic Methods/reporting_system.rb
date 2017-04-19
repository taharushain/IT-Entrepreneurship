require_relative 'store'

class ReportingSystem

	def initialize
		@store = Store.new
		@store.methods.grep(/^get_(.*)_price/) do
			ReportingSystem.define_report_methods_for $1
		end

	end


	def self.define_report_methods_for (item)
		define_method("get_#{item}_desc"){ @store.send("get_#{item}_desc")}
		define_method("get_#{item}_price"){ @store.send("get_#{item}_price")}		
	end

end


rs = ReportingSystem.new

puts "#{rs.get_piano_desc}, costs: #{rs.get_piano_price}"

puts "#{rs.get_guitar_desc}, costs: #{rs.get_guitar_price}"
